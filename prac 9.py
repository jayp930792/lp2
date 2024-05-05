import math

def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a

def find_public_exponent(phi):
    e = 2
    while gcd(e, phi) != 1:
        e += 1
    return e

def mod_inverse(a, m):
    m0, x0, x1 = m, 0, 1
    while a > 1:
        q = a // m
        m, a = a % m, m
        x0, x1 = x1 - q * x0, x0
    return x1 + m0 if x1 < 0 else x1

def rsa_encrypt(msg, e, n):
    return pow(msg, e, n)

def rsa_decrypt(c, d, n):
    return pow(c, d, n)

if __name__ == "__main__":
    try:
        p = int(input("Enter a prime number (p): "))
        if not (p > 1 and all(p % i != 0 for i in range(2, int(math.sqrt(p)) + 1))):
            raise ValueError("Invalid input: p must be a prime number")
        
        q = int(input("Enter another prime number (q): "))
        if not (q > 1 and all(q % i != 0 for i in range(2, int(math.sqrt(q)) + 1))):
            raise ValueError("Invalid input: q must be a prime number")
        
        n = p * q
        phi = (p - 1) * (q - 1)
        e = find_public_exponent(phi)
        d = mod_inverse(e, phi)

        print("Public key (e, n):", e, ",", n)
        print("Private key (d, n):", d, ",", n)

        msg = int(input("Enter plaintext message (as an integer): "))
        print("Plaintext message:", msg)

        encrypted_msg = rsa_encrypt(msg, e, n)
        print("Encrypted message:", encrypted_msg)

        decrypted_msg = rsa_decrypt(encrypted_msg, d, n)
        print("Decrypted message:", decrypted_msg)
        print("Original message:", decrypted_msg)

    except ValueError as ve:
        print("ERROR:", ve)




