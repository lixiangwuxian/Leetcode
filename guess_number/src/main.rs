use std::io;
use std::cmp::Ordering;
use rand::Rng;

fn main() {
    println!("Guess a number!");
    let secret_number = rand::thread_rng().gen_range(1..101);
    
    loop{
        let mut guess_number=String::new();
        io::stdin().read_line(&mut guess_number)
            .expect("Failed to read line");
        let guess_number: u32 =match guess_number.trim().parse() {
            Ok(num)=>num,
            Err(_)=>{
                println!("Please type a number!");
                continue;
            }
        };

        match guess_number.cmp(&secret_number) {
            Ordering::Less => println!("Too small!"),
            Ordering::Greater => println!("Too big!"),
            Ordering::Equal => {
                println!("You win!");
                break;
            }
        }
    }
}