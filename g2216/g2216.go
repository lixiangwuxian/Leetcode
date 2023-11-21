package main

func minDeletion(nums []int) int {
	delcount := 0
	next := 0
	for i := 0; i < len(nums); {
		next = i + 1
		for next < len(nums) && nums[next] == nums[i] {
			delcount++
			next++
		}
		i = next + 1
	}
	if (len(nums)-delcount)%2 != 0 {
		delcount++
	}
	return delcount
}
