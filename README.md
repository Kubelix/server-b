<h1>Introduction</h1>

Sample Spring boot server to receive cache updates from a client for setting up and testing a headless service in a K8s cluster. A sample client code is available here [client-a][1].

This server can be deployed as a headless service by specifying `clusterIP` to `None` in the _Serivce_ specs for the server. Refer to [server-b.yaml][2]. 

<h2>Prerequisites</h2>

1. A docker environment. For this example, I setup Docker Desktop on Windows 10
2. Kubernetes with kubectl CLI
3. A Java IDE such as IntelliJ to build the project locally with Maven and JDK 21
4. A client to send random cache data to this server(from a within the same cluster). Refer to [client-a][1]

<h2>Steps to deploy</h2>

1. First get the Kubernetes cluster info

    ![kubernetes cluster info](https://github.com/Kubelix/server-b/blob/master/utils/images/k8s_cluster_info.png?raw=true)

2. Build the project. This will generate the jar file in the `target` folder.

    ![maven build](https://github.com/Kubelix/server-b/blob/master/utils/images/maven_build.png)

3. Build the docker image

   ![docker build](https://github.com/Kubelix/server-b/blob/master/utils/images/docker_build.png)

   __Note__: Make sure to pass the correct jar file name(as generated in previous step) in Dockerfile:

   ![dockerfile_jar_path](https://github.com/Kubelix/server-b/blob/master/utils/images/dockerfile_jar_path.png)

4. Deploy to K8s cluster

   ![kubectl_deploy](https://github.com/Kubelix/server-b/blob/master/utils/images/kubectl_deploy.png)

5. Verify if pods are created. There should be 3 instances of the server because we specified the `replicas` parameter as 3 in the yaml specs

   ![kubectl_get_pods](https://github.com/Kubelix/server-b/blob/master/utils/images/kubectl_get_pods.png)

6. Check logs for one of the pods to verify if the server is running

   ![server_b_logs](https://github.com/Kubelix/server-b/blob/master/utils/images/server_b_logs.png)

7. Deploy a client in the same cluster as mentioned in prerequisites. Invoking requests from this client will generate logs as below:

   ![client_request_logs](https://github.com/Kubelix/server-b/blob/master/utils/images/server_b_request_logs.png)


[1]: https://github.com/Kubelix/client-a
[2]: https://github.com/Kubelix/server-b/blob/master/deployment/server-b.yaml

