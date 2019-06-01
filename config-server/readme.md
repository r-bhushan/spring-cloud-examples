Why use config server
1. Centeralize Configuration for all environments and application
2. Change config with need to build or re-deploy/restart application

Git Authentication::

1) create ssh key using Git Bash
execute command :
    ssh-keygen -t rsa -b 4096 -C "your_github_email@example.com"
    1.1) its going to create 2 files under  /c/Users/{USER_NAME}/.ssh/id_rsa
        1.1.1) id_rsa : contains private key, gets added in config server 
        1.1.2) id_rsa.pub : contains public key, Which gets register in gihub
     
2) add ssh key in git hub


Ref: https://help.github.com/en/articles/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent
