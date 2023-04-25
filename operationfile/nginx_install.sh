docker pull nginx

docker run --name my-custom-nginx-container -v C:\Users\jonghyun\Desktop\posomo\saltit-server-for-cicd\dockerfile\nginx.conf:/etc/nginx/conf.d/default.conf:ro -p 80:80 -d nginx


docker exec my-custom-nginx-container nginx -s reload