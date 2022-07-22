use std::convert::TryInto;


impl Solution {
    pub fn num_prime_arrangements(n: i32) -> i32 {
        let mut prime_count: i32=0;
        for i in 1..n+1 {
            if Solution::is_prime(i) {
                prime_count += 1;
                //println!("{} is prime", i);
            }
        }
        //println!("prime_count: {}", prime_count);
        let prime_arrangement:i64=Solution::get_factorial(prime_count.into());
        //println!("Prime arrange:{}",prime_arrangement);
        let not_prime_arrangement:i64=Solution::get_factorial((n-prime_count).into());
        //println!("Not Prime arrange:{}",not_prime_arrangement);
        let result:i32=(prime_arrangement*not_prime_arrangement%1000000007 as i64).try_into().unwrap();
        return result;
    }
    fn is_prime(n: i32) -> bool {
        if n <= 1 {
            return false;
        }
        if n==2 || n==3 {
            return true;
        }
        for i in 2..n {
            if n % i == 0 {
                return false;
            }
        }
        return true;
    }
    fn get_factorial(n: i64) -> i64 {
        let mut result: i64=1;
        for i in 1..n+1 {
            result *= i;
            result %= 1000000007;
        }
        return result;
    }
}

struct Solution {}

fn main() {
    println!("{}", Solution::num_prime_arrangements(14));
}
