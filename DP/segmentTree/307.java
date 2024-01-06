class NumArray {
    int[] tree;
    int N = 30000;
    int n;

    public NumArray(int[] nums) {
        tree = new int[2 * N];
        n = nums.length;
        build(nums);
    }
    
    public void build(int[] a) {
        for (int i=0; i<n; i++)     
        tree[n+i] = a[i]; 
      
    // build the tree by calculating parents 
        for (int i = n - 1; i > 0; --i)      
            tree[i] = tree[i<<1] + tree[i<<1 | 1];  
    }

    public void update(int index, int val) {
        tree[index + n] = val;
        index += n;
        for (int i = index; i > 1; i >>= 1) {
            tree[i >> 1] = tree[i] + tree[i ^ 1];
        }
    }
    
    public int sumRange(int l, int r) {
        r+=1;
        int res = 0;

        for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
            if ((l & 1) > 0) {
                res += tree[l++];
            }

            if ((r & 1) > 0) {
                res += tree[--r];
            }
        }
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */