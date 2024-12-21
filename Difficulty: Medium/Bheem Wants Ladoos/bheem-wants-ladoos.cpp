//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
};

Node* newNode(int val) {
    Node* temp = new Node;
    temp->data = val;
    temp->left = NULL;
    temp->right = NULL;

    return temp;
}

Node* buildTree(string str) {
    // Corner Case
    if (str.length() == 0 || str[0] == 'N')
        return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for (string str; iss >> str;)
        ip.push_back(str);

    // Create the root of the tree
    Node* root = newNode(stoi(ip[0]));

    // Push the root to the queue
    queue<Node*> queue;
    queue.push(root);

    // Starting from the second element
    int i = 1;
    while (!queue.empty() && i < ip.size()) {

        // Get and remove the front of the queue
        Node* currNode = queue.front();
        queue.pop();

        // Get the current node's value from the string
        string currVal = ip[i];

        // If the left child is not null
        if (currVal != "N") {

            // Create the left child for the current node
            currNode->left = newNode(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->left);
        }

        // For the right child
        i++;
        if (i >= ip.size())
            break;
        currVal = ip[i];

        // If the right child is not null
        if (currVal != "N") {

            // Create the right child for the current node
            currNode->right = newNode(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }

    return root;
}


// } Driver Code Ends
/*
// node structure:

struct Node
{
    int data;
    Node* left;
    Node* right;
};

*/

class Solution {

  public:
  int ans;
    void sum(Node *root,int k,int & ans){
        if(!root || k<0)
        return;
        ans+=root->data;
        sum(root->left,k-1,ans);
        sum(root->right,k-1,ans);
       
    }
    int solve(Node *root,int home, int k,int &ans){
        if(!root)
        return -1;
        if(root->data==home){          //add k level downstream
            sum(root,k,ans);
            return k-1;                         //add k-1 downstream nodes from parent of target 
        }
        
        int left = solve(root->left,home,k,ans);
        int right = solve(root->right,home,k,ans);
        
        if(left>=0){            //found in left subtree
            ans+=root->data;         //adding target's parent in ans
            sum(root->right,left-1,ans);     //since found in left we have to look in right side of parent node
            return left-1;
        }
        if(right>=0){          //found in right subtree 
            ans+=root->data;        //adding target's parent in ans
            sum(root->left,right-1,ans);   //since found in right we have to look in left side of parent node
            return right-1;
        }
        return -1;
    }
    int ladoos(Node* root, int home, int k) {
        // Your code goes here
        int ans=0;
        solve(root,home,k,ans);
        //int ans = find(root,k);
        return ans;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    getchar();

    while (t--) {
        string s;
        getline(cin, s);
        Node* root = buildTree(s);

        int home, k;
        cin >> home >> k;
        getchar();
        Solution obj;
        cout << obj.ladoos(root, home, k) << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}

// } Driver Code Ends