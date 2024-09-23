from flask import Flask, request, render_template

# flask 초기화
app = Flask(__name__)

'''
function home(){
return 'hello web'
}
'''

# 위의 자바에서의 함수 사용이랑 같은 방법으로 쓰인다는 내용
# 중괄호가 없기 때문에 들여쓰기를 무조건 해주어야 한다
# 괄호 안에 있다는 의미로 똑같은 위치를 가지고 있어야 한다
@app.route("/home") # 주소가 오면 자동적으로 route가 실행됨
def home() :
    a = 10
    print(a)
    return '<h1>hello web</h1>'

@app.route("/login", methods = ['GET','POST'])
def login() : 
    # 넘겨받은 파라케터 출력
    print(request.method)

    if request.method == 'GET' :
        # GET 방식
        id = request.args.get("id")
        print("id : ",id)

    elif request.method == 'POST' :
        # POST 방식
        id = request.form.get("id")
        print("id : ",id)
    else :
        print("다른 메소드")

    # POST 방식
    # id = request.form.get("id")

    # return f'너의 아이디는 your id is {id} 입니다'
    return render_template('main.html', id2 = id, d ={'k' : 'v'})


@app.route("/join")
def join() :
    return render_template('join.html')



# 서버 구동
# flask 기본 포트 : 5000
app.run(port=5000, debug = True)




