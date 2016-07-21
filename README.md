## How to use this demo

### Setting global environment variables

modify scripts/setenv.sh according to your own system.

BTW: EXPORT_DIR is the folder which contains generated data files


### Run cache servers

	./run-cache-server
	
The demo will run 6 coherence nodes by default


### Load sample data

	./run-dataload.sh [records count]

for examples:
	./run-dataload.sh 1000000
	
### Export Coherence data to .csv files

	./run-export.sh

### Stop cache servers

	./stop-cache-servers.sh

### Test result

It takes 30sec that export 1000000 records to 6 data file on a 6 cache servers(512M/cache server)  cluster in single host(normal laptop). 