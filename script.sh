(trap 'kill 0' SIGINT;

java -jar demoproj-0.0.1-SNAPSHOT.jar &
sleep 10
cd EnsolversDemoFrontend
npm install 
npm start
)