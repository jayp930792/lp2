#Write a Java/C/C++/Python program to implement RSA algorithm.
# Python for RSA asymmetric cryptographic algorithm.
# For demonstration, values are
# relatively small compared to practical application
import math
def gcd(a, h):
    temp = 0
    while(1):
        temp = a % h
        if (temp == 0):
            return h
        a = h
        h = temp
p = int(input("Enter Prime number of P: "))
q = int(input("Enter Prime number of Q: "))
n = p*q
e = 2
phi = (p-1)*(q-1)
while (e < phi):
# e must be co-prime to phi and
# smaller than phi.
    if(gcd(e, phi) == 1):
        break
    else:
        e = e+1
# Private key (d stands for decrypt)
# choosing d such that it satisfies
# d*e = 1 + k * totient
k = 2
d = (1 + (k*phi))/e
# Message to be encrypted
msg = float(input("Enter Plain Text: "))
print("Message data = ", msg)
# Encryption c = (msg ^ e) % n
c = pow(msg, e)
c = math.fmod(c, n)
print("Encrypted data = ", c)
# Decryption m = (c ^ d) % n
m = pow(c, d)
m = math.fmod(m, n)
print("Original Message Sent = ", m)