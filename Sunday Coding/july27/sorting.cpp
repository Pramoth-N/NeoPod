#include<iostream>
#include<vector>

using namespace std;

int main()
{
    int n;
    cin>>n;
    if(n<=0){
        cout<<"Invalid input";
        return 0;
    }
    vector<string> name(n);
    vector<int> age(n);
    for(int i=0;i<n;i++){
        cin>>name[i]>>age[i];
    }
    
    for(int i=0;i<n;i++){
        for(int j=0;j<n-i-1;j++){
            if(age[j] > age[j+1]){
                swap(name[j],name[j+1]);
                swap(age[j],age[j+1]);
                
            } else if(age[j] == age[j+1]){
                if(name[j]>name[j+1]){
                    swap(name[j],name[j+1]);
                }
            }
        }
    }
    
    for(int i=0;i<n;i++){
        cout<<name[i]<<" "<<age[i]<<"\n";
    }

}