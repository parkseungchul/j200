. ./000_SET_ENV

echo "nginx 파일 생성"
envsubst < default-template.conf | sed -e 's/§/$/g' > default.conf

