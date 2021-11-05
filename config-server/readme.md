Why use config server
1. Centeralize Configuration for all environments and application
2. Change config with need to build or re-deploy/restart application

Git Authentication::

1. create ssh key using Git Bash
execute below command, its going to create 2 files under  /c/Users/{USER_NAME}/.ssh/id_rsa:
    ```
    ssh-keygen -t rsa -b 4096 -C "your_github_email@example.com"
    ```
   - id_rsa : contains private key, gets added in config server 
   - id_rsa.pub : contains public key, Which gets register in gihub
     
2. add ssh key in git hub


Ref: https://help.github.com/en/articles/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent
