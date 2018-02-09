#include <iostream>
using namespace std;

template class T
class Node<T> {
    public:
        Node<T>(T data) : m_data(data)
                          m_link(NULL)
        {}
    private:
    T m_data;
    Node<T>* m_link;
};

template class T
class List {
public:
    void insert(T data, int position);
    void push(T data);
    void removeAll();
    void remove(T data);
    void reverse(Node<T> **head);
    bool detectLoop(Node<T> **head);
    int size();
private:
    Node<T> *m_head;
}

int main() {
    return 0;
}
