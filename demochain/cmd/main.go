package main

import "demochain/core"

func main(){
	bc :=core.NewBlockchain()
	bc.SendData("Send 1 BTC to James")
	bc.SendData("Send 1 EOS to Jenny")
	bc.Print()
}