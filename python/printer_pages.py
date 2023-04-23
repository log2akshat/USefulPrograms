# !/bin/python

# Program to output n numbers of pages to print to feed on the
# printer menu when 2 pages are selected to print on a paper.

import itertools

first_page_number=int(input("Enter First Page Number: "))
second_page_number=int(input("Enter Second Page Number: "))
last_page_number=int(input("Enter Last Page Number: "))

INC_VALUE=4

list1=list(range(first_page_number, last_page_number, INC_VALUE))
list2=list(range(second_page_number, last_page_number, INC_VALUE))
new_list=[]
for a,b in itertools.zip_longest(list1,list2):
    if a:
        new_list.append(a)
    if b:
        new_list.append(b)
print(new_list)
print("Total pages required to print are: %s" % len(new_list))
