import socket
import math
import fibonacci

def fib(n):
    return fibonacci.fibo(n)
def main():
    # nc 128.199.236.209 17845
    # create socket
    s = socket.socket()
    # connect to socket
    s.connect(("128.199.236.209", 17845))
    while True:
        res = s.recv(1024).split("\n")
        res2 = res[0].split("Ke: ")
        res3 = res[0].split("index: ")
        # print res3
        if res[0] == '':
            break
        print res[0]
        if len(res2) > 1:
            soal = res2[1]
            jawab = (int(soal)*(int(soal)+1))/2
            s.send(str(jawab))
        elif len(res3) > 1:
            for i in range(1, 11):
                print "Ke-"+str(i)+" : " ,fib(i)
            # soal = res3[1]
            # jawab = fib(int(soal))+1
            # print jawab
            # s.send(str(jawab))

if __name__ == '__main__':
    main()