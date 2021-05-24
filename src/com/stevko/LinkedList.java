package com.stevko;

public class LinkedList <T extends Comparable<T>> {
    private Node<T> head;
    public LinkedList(){}
    
    public void insertAtHead(T data){
        Node<T> node = new Node<>(data);
        if(head==null){
            node.setNext(head);
        }
        head=node;
    }
    public void insertAtTail(T data){
        Node<T> node = new Node<>(data);
        if(head==null){
            head=node;
            return;
        }
        Node<T> curr=head;
        while(curr.getNext()!=null){
            curr=curr.getNext();
        }
        curr.setNext(node);

    }
    public void insert(T data,int index){
        if(index<=0){
            insertAtHead(data);
            return;
        }
        Node<T> curr=head;
        int currindex=1;
        while(curr.getNext()!=null&&currindex<index){
            curr=curr.getNext();
            currindex++;
        }
        Node<T> next=curr.getNext();
        Node<T> newNode=new Node<>(data);
        newNode.setNext(next);
        curr.setNext(newNode);
    }
    public void delete(T data){
        Node<T> curr=head;
        Node<T> prev=null;
        while(curr!=null){
            if(curr.getData().equals(data)){
                if(prev==null){
                    head=head.getNext();
                }
                else{
                    prev.setNext(curr.getNext());
                }
                break;
            }
            prev=curr;
            curr=curr.getNext();
        }
    }
    public int countNodes(){
        Node<T> curr =head;
        int count=0;
        while(curr!=null){
            curr=curr.getNext();
            count++;
        }
        return count;
    }
    public T pop(){
        if(head==null)
            return null;
        Node<T> first=head;
        head=head.getNext();
        return first.getData();
    }
    public boolean contains(T data){
        Node<T> curr=head;
        while(curr!=null){
            if(curr.getData().equals(data))
                return true;
            curr=curr.getNext();
        }
        return false;
    }
    @Override
    public String toString(){
        if(head==null)
            return "";
        return head.toString();
    }
}
