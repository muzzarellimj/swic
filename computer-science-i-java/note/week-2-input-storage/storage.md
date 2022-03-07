# Storage

With respect to storage, there are a couple of data types discussed in this section: primitive, which includes storage 
of integers, real numbers, letters, and boolean values; and abstract, which includes classes written in Java that are 
meant to house data in some capacity. These primitive data types also have corresponding classes called 'wrappers', 
which are as follows:

| Class   | Primitive | Length           |
|:--------|:----------|:-----------------|
| Byte    | byte      | 1 byte, 8 bits   |
| Short   | short     | 2 bytes, 16 bits |
| Integer | int       | 4 bytes, 32 bits |
| Long    | long      | 8 bytes, 64 bits |
| -       | -         | -                |
| Float   | float     | 4 bytes, 32 bits |
| Double  | double    | 8 bytes, 64 bits |

## Number Systems

We deal in a couple of number systems: binary of base 2, octal of base 8, and hexadecimal of base 16.

### Binary Expansion

Binary numbers are represented only with 1 and 0 (e.g., 0110) so we deal in 2^1 rather than 10^1. The base value is 
represented with subscript immediately following the number. Traditional number expansion looks like 
`418 = 4*10^2 + 1*10^1 + 8*10^0 = 418` but binary number expansion `0110 = 0*2^3 + 1*2^2 + 1*2^1 + 0*1^0 = 6`.