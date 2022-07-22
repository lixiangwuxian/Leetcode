#include "tool.h"
using namespace std;

class Node
{
public:
    bool val;
    bool isLeaf;
    Node *topLeft;
    Node *topRight;
    Node *bottomLeft;
    Node *bottomRight;

    Node()
    {
        val = false;
        isLeaf = false;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }

    Node(bool _val, bool _isLeaf)
    {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = NULL;
        topRight = NULL;
        bottomLeft = NULL;
        bottomRight = NULL;
    }

    Node(bool _val, bool _isLeaf, Node *_topLeft, Node *_topRight, Node *_bottomLeft, Node *_bottomRight)
    {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};

class Solution
{
public:
    bool checkValue(vector<vector<int>> &grid)
    {
        for (int i = 0; i < grid.size(); i++)
        {
            for (int j = 0; j < grid[0].size(); j++)
            {
                if (grid[i][j] != grid[0][0])
                {
                    return false;
                }
            }
        }
        return true;
    }

    Node *construct(vector<vector<int>> &grid)
    {
        Node *parent;
        if (checkValue(grid))
        {
            parent = new Node((bool)grid[0][0], true);
            return parent;
        }
        // Cut the grid into four parts
        vector<vector<int>> topLeft;
        vector<vector<int>> topRight;
        vector<vector<int>> bottomLeft;
        vector<vector<int>> bottomRight;
        for (int i = 0; i < grid.size() / 2; i++)
        {
            topLeft.push_back(vector<int>());
            topRight.push_back(vector<int>());
            bottomLeft.push_back(vector<int>());
            bottomRight.push_back(vector<int>());
            for (int j = 0; j < grid[0].size() / 2; j++)
            {
                topLeft[i].push_back(grid[i][j]);
                topRight[i].push_back(grid[i][grid[0].size() / 2 + j]);
                bottomLeft[i].push_back(grid[grid.size() / 2 + i][j]);
                bottomRight[i].push_back(grid[grid.size() / 2 + i][grid[0].size() / 2 + j]);
            }
        }
        // Construct four parts
        Node *topLeftNode = construct(topLeft);
        Node *topRightNode = construct(topRight);
        Node *bottomLeftNode = construct(bottomLeft);
        Node *bottomRightNode = construct(bottomRight);
        // Construct the parent node
        parent = new Node(true, false, topLeftNode, topRightNode, bottomLeftNode, bottomRightNode);
        return parent;
    }
};