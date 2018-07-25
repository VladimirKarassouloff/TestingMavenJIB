##### Jib plugin : https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin

#### Setuping the docker-credential-helper
```
Hi. I`m sorry for my English. After spending some time, i was able to setup credential store and maybe my experience will help you.

I used ubuntu 18.04 and did all action as root user.

download "docker-credential-pass".
wget https://github.com/docker/docker-credential-helpers/releases/download/v0.6.0/docker-credential-pass-v0.6.0-amd64.tar.gz

unpack tar -xf docker-credential-pass-v0.6.0-amd64.tar.gz

i couldn`t configure $PATH environment variable, so i copied unpacked file to /usr/bin directory.

check that docker-credential-pass work. To do this, run command docker-credential-pass. You should see: "Usage: docker-credential-pass <store|get|erase|list|version>".

install gpg and pass. apt install gpg pass

gpg --generate-key. Enter your name, mail, etc. You will get gpg-id like "5BB54DF1XXXXXXXXF87XXXXXXXXXXXXXX945A". Copy it to clipboard.

pass init (paste from clipboard)

pass insert docker-credential-helpers/docker-pass-initialized-check and set the next password "pass is initialized" (without quotes).

pass show docker-credential-helpers/docker-pass-initialized-check. You should see pass is initialized.

docker-credential-pass list. You should see {} or another data. You shouldn`t see error like "pass store is uninitialized".

nano ~/.docker/config.json. Set in root node the next line "credsStore": "pass" save ctrl+o.

after docker login and etc.

I'm not a guru on unux based OS and some actions can be done better. I hope someone will help my answer.

~~ Ayrat-Kh - https://github.com/docker/docker-credential-helpers/issues/102

```


#### Publishing the image to docker hub

##### Any

```
mvn compile jib:build -Dimage=<ImageNameOnDockerHub>```
```

##### This project

```
mvn compile com.google.cloud.tools:jib-maven-plugin:0.9.6:build -Dimage=vladimirkarassouloff/testjib

docker pull vladimirkarassouloff/testjib

wget -qO- http://172.XXX.XXX.XXX:8080/test?url=test
OR
wget -qO- http://127.0.0.1:8080/test?url=test
```
