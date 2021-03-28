package com.javaBasic.Dijkstra;

/**
 * @Author: Jay
 * @Date: Created in 15:46 2019/1/25
 * @Modified By:
 */
//边节点
public class Edge {
    //对应的点下表
    public int vertexId;
    //边的权重
    public int weight;
    //下一个边节点
    public Edge next;

    public int getVertexId() {
        return vertexId;
    }

    public int getWeight() {
        return weight;
    }

    public Edge getNext() {
        return next;
    }

    public void setNext(Edge next) {
        this.next = next;
    }

    public void setVertexId(int vertexId) {
        this.vertexId = vertexId;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    //getter and setter自行补充
}
