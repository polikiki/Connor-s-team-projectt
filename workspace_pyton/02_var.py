a = 10
naver = 1
nvar =2  # 변수선언문이 아예 없음 변수에 오타 중의

b = a // 3 # 내림
print(b)
print(-a//3)
print(a%3)

print(2 ** 10) # 거듭 제곱

# int 자료형으로 형변환
a = int(-3.3) # 실수일 경우 버림
print(a)
print(int('100')+1)
# print(int('10asdf0')+1)

# print = 10 
# print(a)

a = 10
print( type(a) )
a= 'abc'
print(type(print))

# 정밀도
a = 0.1234567890123456789
print(a) # 파이썬의 정밀도 : 소수점 14자리까지

a, b, c = 10, 20 ,30

t= (10,20,30)

print(a,b,c)

a = True
b = False
c = None # null 없고 대신에 None
# 파이썬에서 False로 인식되는 경우 : False, None, 0.0, 빈컨테이너
# False만 아니라면 True로 인식한다

# a = input()
# print(a)

print('abc' == 'abc') # 문자도 ==으로 비교한다

a= 3 > 5
b= 7 > 5
print(a and b)
print(a or b)
print( not(a or b))


id ='아이디'
html = '''
<div>
    <strong>아이디</strong>
</div>
'''
print(html)

html = f'''
<div>
    <strong>{id}</strong>
</div>
'''
print(html)

print("쌍따옴표 기호는 \" 입니다")



