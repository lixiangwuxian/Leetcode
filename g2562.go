package main

import (
	"fmt"
)

func findTheArrayConcVal(nums []int) int64 {
	var head, tail int64
	head = 0
	tail = int64(len(nums) - 1)
	var sum int64 = 0
	for head <= tail {
		var digits int = 10
		if nums[tail] == 10000 {
			digits = 100000
		} else if nums[tail] < 10000 && nums[tail] >= 1000 {
			digits = 10000
		} else if nums[tail] < 1000 && nums[tail] >= 100 {
			digits = 1000
		} else if nums[tail] < 100 && nums[tail] >= 10 {
			digits = 100
		}
		// var digits = int(math.Pow(10.0, float64(int(math.Log10(float64(nums[tail]))+1))))
		if head < tail {
			currentNum := nums[head]*digits + nums[tail]
			head++
			tail--
			sum += int64(currentNum)
		} else if head == tail {
			currentNum := int64(nums[head])
			sum += currentNum
			break
		}
	}
	return sum
}

func main() {
	//test findTheArrayConcVal
	var nums = []int{5, 14, 13, 8, 12}
	fmt.Println(findTheArrayConcVal(nums))
}

// Run `go mod init` to create a new module
