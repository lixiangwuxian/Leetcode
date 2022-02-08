struct node
{
    int value;
    node *next;
};
struct nodelist
{
    node *this_point;
    nodelist *next;
};
class MinStack
{
private:
    node *top_node;
    nodelist *min_list;

public:
    /** initialize your data structure here. */
    MinStack()
    {
        min_list = new nodelist;
        min_list->this_point=new node;
        min_list->this_point->value = __INT_MAX__;
        min_list->this_point->next = nullptr;
        min_list->next = nullptr;
    }

    void push(int x)
    {
        node *new_top = new node;
        new_top->value = x;
        new_top->next = this->top_node;
        this->top_node = new_top;
        if (new_top->value <= min_list->this_point->value)
        {
            nodelist *new_min = new nodelist;
            new_min->this_point = new_top;
            new_min->next = this->min_list;
            this->min_list = new_min;
        }
    }

    void pop()
    {
        node *toDel = this->top_node;
        this->top_node = toDel->next;
        if (this->min_list->this_point == toDel)
        {
            nodelist *toDel = this->min_list;
            this->min_list = toDel->next;
            delete toDel;
        }
        delete toDel;
    }

    int top()
    {
        return this->top_node->value;
    }

    int min()
    {
        return this->min_list->this_point->value;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->min();
 */