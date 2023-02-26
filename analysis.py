
# importing the requests library
import requests
import json

import matplotlib.pyplot as plt
# api-endpoint
URL = "http://localhost:8080/coen6317/test"
headers = {
  'Content-Type': 'application/json'
}
no_gets_list = [2,5,10]
no_clients_list =[10,50,100]
outlist =[]
i=0
colour = ["red", "blue", "yellow", "green", "orange", "purple", "brown", "pink", "black"]
ax = plt.subplot(111, projection='3d')
for no_gets in no_gets_list:
    for no_clients in no_clients_list:
    # defining a params dict for the parameters to be sent to the API
        PARAMS = {'url':"http://204.216.108.46:8080/audio", "no_gets":no_gets,"no_clients":no_clients}
        response = requests.request("GET", URL, headers=headers, params = PARAMS)
   
        # extracting data in json format
        data = response.text[1:-2].split(",")
        data= [int(e) if e.isdigit() else e for e in data]
        out = {"no_gets":no_gets,"no_clients":no_clients,'time_duration': data }
     
        outlist.append(out)
        ax.plot([no_clients]*len(data),[no_gets]*len(data), data, c =colour[i],label="Parallel Clients :" +str(no_clients)+" Ratio of get to post: "+str(no_gets)+":1")
        i+=1
plt.legend(loc='upper left', numpoints=1, ncol=3, fontsize=8, bbox_to_anchor=(0, 0))
ax.set_ylabel("Ratio of get to post")
ax.set_xlabel("Number of Clients")
ax.set_zlabel("Time in Mili seconds")
plt.show()

print(outlist)
  
