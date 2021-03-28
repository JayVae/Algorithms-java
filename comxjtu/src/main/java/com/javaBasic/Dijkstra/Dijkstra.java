package com.javaBasic.Dijkstra;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: Jay
 * @Date: Created in 15:48 2019/1/25
 * @Modified By:
 */
public class Dijkstra {
    public Graph gh;
    public Dijkstra(Graph gh){
        this.gh=gh;
    }
    //未求出最短路径的点集合
    public ArrayList<Integer> unVisited=new ArrayList();
    //已求出最短路径的点集合
    public ArrayList hasVisited=new ArrayList();
    //记录从起点到其他任意一点的路径长度
    public int distances[];
    //记录Path[i]表示从S到i的最短路径中，结点i之前的结点的编号,即对应点的前一个节点
    public int paths[];
    /**
     * 初始化各点距离及路径
     */
    public void init(int x,int y ){
        distances=new int[gh.vertexNum];
        paths=new int[gh.vertexNum];
        for(int i=0;i<distances.length;i++){
            distances[i]=Integer.MAX_VALUE;
        }
        distances[x]=0;
//把与x相邻的点的距离求出,并标准初始路径
        for(Edge edge=gh.vertexList[x].firstEdge;edge!=null;edge=edge.next){
            distances[edge.vertexId]=edge.weight;
            paths[edge.vertexId]=x;
        }
//初始化未知最短路点集合和已知最短路集合
        unVisited.clear();
        hasVisited.clear();
        hasVisited.add(x);
//其余点为未知
        for(int i=0;i<gh.vertexList.length;i++){
            if(i!=x){
                unVisited.add(i);
            }
        }
    }
    /**
     * 求从x到y的最短路径,并返回该路径
     * @param x
     * @param y
     */
    public void Dijkstra(int x,int y){
        init(x,y);
//如果
        System.out.println("开始执行...");
        while(!unVisited.isEmpty()){
            int vertexId=pickMinInUnvisited(x);
            if(vertexId==-1)
                break;
            //将其加入到已hasvisited集合中,并从未访问列表中去除
            hasVisited.add(vertexId);
            unVisited.remove((Integer)vertexId);
            //对u为起点,相邻的点为终点的临接点进行松弛操作
            relax(vertexId);
        }
        for(int i=0;i<distances.length;i++){
            System.out.println(x+"-->"+i+"距离为"+distances[i]);
        }
        ArrayList mypath=printPath(x,y);
        StringBuilder sb=new StringBuilder();
        sb.append("路径为:");
        for(int i=0;i<mypath.size();i++){
            sb.append(mypath.get(i)+"-->");
        }
        sb.delete(sb.length()-3,sb.length());
        System.out.println(sb.toString());
    }
    /**
     * 求出从x到y的路径,由于path中存放的该点的前一个点的位置
     * @param x
     * @param y
     */
    public ArrayList<String> printPath(int x,int y){
        ArrayList mypaths=new ArrayList();
        while(y!=x){
            mypaths.add(y);
            y=paths[y];
        }
        mypaths.add(x);
        //路径倒置,需要反置回来
        Collections.reverse(mypaths);
        return mypaths;
    }
    /**
     * 考察所有以点u为起点的边,对每一条边进行松弛操作。
     * @param u
     */
    public void relax(int u){
        for(Edge edge=gh.vertexList[u].firstEdge;edge!=null;edge=edge.next){
            int v=edge.vertexId;
            //对v进行松弛,看是否满足distances[v]>distances[u]+w[u][v]
            int w=edge.weight;
            if(distances[v]>distances[u]+w){
                distances[v]=distances[u]+w;
                //记录v的最短路径时,前一个节点为u
                paths[v]=u;
            }
        }
    }
    /**
     * 从未求出最短路径的集合中找到与原点最近的点
     * @param x
     */
    public int pickMinInUnvisited(int x){
        int minIndex=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<distances.length;i++){
            if(unVisited.contains(i)){
                if(distances[i]<min){
                    minIndex=i;
                    min=distances[i];
                }
            }
        }
        return minIndex;
    }
    public static void main(String[]args){
        Graph g=new Graph(5);
        g.initVertext();
        g.addEdge(0,1,2);
        g.addEdge(0,2,2);
        g.addEdge(1,4,1);
        g.addEdge(1,3,3);
        g.addEdge(2,3,3);
        g.addEdge(4,3,1);
        Dijkstra dj=new Dijkstra(g);
        dj.Dijkstra(1,3);
    }
}
