#include <stdio.h>
#include <sys/stat.h>
#include <pwd.h>
#include <sys/types.h>
#include <libgen.h>
#include <dirent.h>
#include <grp.h>
#include <time.h>
#include <string.h>
#include <pthread.h>
#include <stdlib.h>
#include <unistd.h>
#include <ctype.h>
void print_type_of_file(struct stat st){
	switch (st.st_mode & S_IFMT) {
		 case S_IFBLK:  printf("b");break;
		 case S_IFCHR:  printf("c");break;
		 case S_IFDIR:  printf("d");break;
		 case S_IFIFO:  printf("p");break;
		 case S_IFLNK:  printf("l");break;
		 case S_IFREG:  printf("-");break;
		 case S_IFSOCK: printf("s");break;
	}
}


void print_full_file(struct stat st, const char* name){
    print_type_of_file(st);
    printf( (st.st_mode & S_IRUSR) ? "r" : "-");
    printf( (st.st_mode & S_IWUSR) ? "w" : "-");
    printf( (st.st_mode & S_IXUSR) ? "x" : "-");
    printf( (st.st_mode & S_IRGRP) ? "r" : "-");
    printf( (st.st_mode & S_IWGRP) ? "w" : "-");
    printf( (st.st_mode & S_IXGRP) ? "x" : "-");
    printf( (st.st_mode & S_IROTH) ? "r" : "-");
    printf( (st.st_mode & S_IWOTH) ? "w" : "-");
    printf( (st.st_mode & S_IXOTH) ? "x" : "-");
                   
    struct tm *tm;
    char buf[200];  
    tm = localtime(&(st.st_mtime));
    strftime(buf, sizeof(buf), "%b %-2d %H:%M", tm); 
    printf(" %ld %+1s%+1s%5ld %s %s\n",
                st.st_nlink, 
                getpwuid(st.st_uid)->pw_name, 
                getgrgid(st.st_gid)->gr_name, 
                st.st_size,buf, 
                name);
}
int ls( const char* dirname, int flags[], int argc){
    DIR *dir;
    int size = 10;
    struct dirent **dp = malloc(size * sizeof(struct dirent *));

    struct stat *st= malloc(size * sizeof(struct stat) );

    char a[200][100];
    if((dir=opendir(dirname)) == NULL){
        struct stat singel_st;
		char err_msg[100];
        if(stat(dirname, &singel_st) == -1){
			snprintf(err_msg, sizeof(err_msg), "ls: cannot access %s", dirname);
			perror(err_msg);
			return -1;
        }else if((singel_st.st_mode & S_IRUSR) == 0){
			snprintf(err_msg, sizeof(err_msg), "ls: cannot open directory %s", dirname);
			perror(err_msg);
			return -1;
		}
        if(flags[0] == 1){
            print_full_file(singel_st,dirname);
            
        }else{
    		print_type_of_file(singel_st);
            printf(" %s\n", dirname);
        }
    }else{
		if((flags[1] == 1 || argc > 2) ){
        	printf("%s:\n", dirname);
    	}
        int i=0;
        int index = 0;
        int blocks = 0;
        while(((dp[index] = readdir(dir))) != NULL){
			if(strcmp(dp[index]->d_name,".") == 0 || strcmp(dp[index]->d_name,"..") == 0){
					continue;				
			}
            if(index == size){
                size = size * 2;
                dp = realloc(dp, size * sizeof(struct dirent *));
                st = realloc(st, size * sizeof(struct stat));
            }
            char name[200];
            snprintf(name, sizeof(name), "%s/%s", dirname, dp[index]->d_name);
            if(stat(&name, &st[index]) == -1){
                char err_msg[100];
				snprintf(err_msg, sizeof(err_msg), "ls: cannot access %s: ", name);
				perror(err_msg);
				return -1;
            }
            if(flags[2] == 0 && dp[index]->d_name[0] == '.'){
                continue;
            }
            else{
                blocks += st[index].st_blocks;
            }
            index++;
        }
        if(flags[0] == 1){
			printf("total: %d\n", blocks/2);
		}
        for(int b = 0;b < index;b++){
                if(S_ISDIR(st[b].st_mode) && flags[1] == 1){
                    char path[1024]; 			
                    snprintf(path, sizeof(path), "%s/%s", dirname, dp[b]->d_name);
                    strcpy(a[i],path);
                    i++;
                }
                if(flags[0] == 1){
                    print_full_file(st[b], dp[b]->d_name);
                }else{
					print_type_of_file(st[b]);
                    printf(" %s\n", dp[b]->d_name); 
                }
        }

		closedir(dir);
		free(dp);
		free(st);
		for(int b=0;b<i;b++){        
			printf("\n");
			ls(a[b],flags, argc);
			
		}

    }
	return 0;
}
int main(int argc, char** argv){
    int c;
    int lflag = 0;
    int rflag = 0;
    int aflag = 0;
    int flags[3] = {0,0,0};
    int index;
    char fileName[40];
    int opts = 0;
    while ((c = getopt (argc, argv, "lraLRA")) != -1)
	{     
		if(c == 'l' || c=='L'){
		    flags[0] = 1;
			opts++; 
		}else if(c == 'r' || c=='R'){
		        flags[1] = 1;
			opts++; 
		}else if(c == 'a' || c== 'A'){
		        flags[2] = 1;
			opts++; 
		}
    }
	
	if(optind == argc){
		ls(".", flags, 2);
	}else{
     	for (index = optind; index < argc; index++){
     	    
			ls(argv[index],flags, argc - opts);
			if(index < argc - 1){
				printf("\n");
			}
		}
	}
}
