<h1>Introduction</h1>

Sample Spring boot server to receive cache updates from a client for setting up and testing a headless service in a K8s cluster. A sample client code is available here [client-a][1].

This server can be deployed as a headless service by specifying `clusterIP` to `None` in the _Serivce_ specs for the server. Refer to [server-b.yaml][2]. 

<h2>Prerequisites</h2>
1. A docker environment. For this example, I setup Docker Desktop on Windows 10
2. Kubernetes with kubectl CLI
3. A Java IDE such as IntelliJ to build the project locally with Maven and JDK 21.

<h2>Steps to deploy</h2>
1. First get the Kubernetes cluster info: ![kubernetes cluster info](https://github.com/user-attachments/assets/18a7c383-ba4b-4d77-bd27-0285bf9344b8)
   
2. 


[1]: https://github.com/Kubelix/client-a
[2]: https://github.com/Kubelix/server-b/blob/master/deployment/server-b.yaml

