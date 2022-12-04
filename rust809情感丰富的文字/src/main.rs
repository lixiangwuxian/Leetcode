impl Solution {
    pub fn expressive_words(s: String, words: Vec<String>) -> i32 {
        let org_alpha_list=Self::split_word(s);//将s分割为由字母-长度结构体组成的容器
        let mut count:i32 = 0;
        for i in words.iter() {
           if Self::check_one_word(&org_alpha_list,i.to_string()) {//对每个词语分别进行比较，结果为真则计数加一
               count+=1;
           }
        }
        count
    }
    pub fn check_one_word(src_word: &Vec<AlphaBlock>,dst_word:String) -> bool {//对词语进行比较
        let alphas=Self::split_word(dst_word);//将每个词语分割为由字母-长度结构体组成的容器
        if src_word.len()!=alphas.len() {
            return false;
        }
        for i in 0..alphas.len() {
            if !Self::check_replaceable(&src_word[i],&alphas[i]) {
                return false;
            }
        }
        true
    }
    pub fn check_replaceable(src:&AlphaBlock,dst:&AlphaBlock) -> bool {
        if src.alpha != dst.alpha{
            return false;
        }
        if src.count == dst.count {
            return true;
        }
        if src.count > dst.count {
            if src.count>=3 {
                return true;
            }
        }
        false
    }
    pub fn split_word(word:String) -> Vec<AlphaBlock>{
        let mut alpha_list = Vec::<AlphaBlock>::new();
        for i in word.chars() {
            if alpha_list.len()>=1 && i==alpha_list[alpha_list.len()-1].alpha && !alpha_list.is_empty() {
                let alpha_len = alpha_list.len();
                alpha_list[alpha_len-1].count += 1;
            } else {
                let block=AlphaBlock{
                    alpha:i,
                    count:1,
                };
                alpha_list.push(block);
            }
        }
        alpha_list
    }
}
struct AlphaBlock{
    alpha:char,
    count:i32,
}

struct Solution;
fn main() {
    let s = String::from("aaa");
    let words = vec![String::from("aaaa")];
    let result = Solution::expressive_words(s,words);
    println!("{}",result);
}

