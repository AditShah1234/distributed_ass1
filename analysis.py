
# importing the requests library
import requests
import json
import math
import matplotlib.pyplot as plt
# api-endpoint
URL = "http://localhost:8080/coen6317/test"
headers = {
  'Content-Type': 'application/json'
}

no_gets_list = [2,5,10]
no_gets_list2 = [1,3,5]
no_clients_list =[10,50,100]
outlist =[]
i=0
split = 0.30
colour = ["red", "blue", "yellow", "green", "orange", "purple", "brown", "pink", "black"]
ax = plt.subplot(111, projection='3d')
for no_get in no_gets_list:
    for no_clients in no_clients_list:
        no_get_type1 = math.floor(no_get*split) 
        no_get_type2 = math.ceil(no_get*split) 
    # defining a params dict for the parameters to be sent to the API
        PARAMS = {'url':"http://204.216.108.46:8080/audio", "no_gets1":no_get_type1,"no_gets2":no_get_type2,"no_clients":no_clients}
        response = requests.request("GET", URL, headers=headers, params = PARAMS)
   
        # extracting data in json format
        data = response.text[1:-2].split(",")
        data= [int(e) if e.isdigit() else e for e in data]
        out = {"no_gets":no_get,"no_clients":no_clients,'time_duration': data }
     
        outlist.append(out)
        ax.plot([no_clients]*len(data),[out["no_gets"]]*len(data), data, c =colour[i],label="Parallel Clients :" +str(no_clients)+" Ratio of get to post: "+str(out["no_gets"])+":1")
        i+=1
plt.legend(loc='upper left', numpoints=1, ncol=3, fontsize=8, bbox_to_anchor=(0, 0))
ax.set_ylabel("Ratio of get to post")
ax.set_xlabel("Number of Clients")
ax.set_zlabel("Time in Mili seconds")
ax.set_title("3d garph with split : "+str(split))
plt.show()



for out in outlist:
    if out["no_gets"] == 2:
        plt.plot(range(out["no_clients"]),out["time_duration"],label = "No of clients : "+str(out["no_clients"]))
plt.xlabel("Client number")
plt.ylabel("Time in milisec")
plt.title('Plot for client with get to post ratio of 2:1 and split of get request '+str(split))

plt.legend(loc='upper left', numpoints=1, ncol=3, fontsize=8, bbox_to_anchor=(0, 0))
plt.show()

for out in outlist:
    if out["no_gets"] == 5:
        plt.plot(range(out["no_clients"]),out["time_duration"],label = "No of clients : "+str(out["no_clients"]))
plt.xlabel("Client number")
plt.ylabel("Time in milisec")
plt.title('Plot for client with get to post ratio of 5:1 and split of get request '+str(split))
plt.legend(loc='upper left', numpoints=1, ncol=3, fontsize=8, bbox_to_anchor=(0, 0))
plt.show()

for out in outlist:
    if out["no_gets"] == 10:
        plt.plot(range(out["no_clients"]),out["time_duration"],label = "No of clients : "+str(out["no_clients"]))
plt.xlabel("Client number")
plt.ylabel("Time in milisec")
plt.title('Plot for client with get to post ratio of 10:1 and split of get request '+str(split))

plt.legend(loc='upper left', numpoints=1, ncol=3, fontsize=8, bbox_to_anchor=(0, 0))
plt.show()

for out in outlist:

      plt.plot(range(out["no_clients"]),out["time_duration"],label = "No of clients : "+str(out["no_clients"])+"Ratio : "+str(out["no_gets"])+":1")
plt.xlabel("Client number")
plt.ylabel("Time in milisec")
plt.title('Plot for all client and split of get request '+str(split))

plt.legend(loc='upper left', numpoints=1, ncol=3, fontsize=8, bbox_to_anchor=(0, 0))
plt.show()