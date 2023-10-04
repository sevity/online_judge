# online_judge
spring boot로 만드는 online_judge 사이트

## 1. auth-service
url: http://localhost:9991
### build cmd
```bash
online_judge/auth-service && ./build.sh && docker build -t auth-service .
```
### run cmd
```bash
online_judge/auth-service/docker_run.sh 9991
```


## 2. frontend-service

# related environment
## airflow
http://localhost:8081

## supervisor
* conf files: /etc/supervisor/conf.d/
* log files: /var/log/supervisor

