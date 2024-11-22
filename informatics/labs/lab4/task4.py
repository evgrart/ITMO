import task0
import task1
import task2
import timeit


def check_0():
    with open('schedule.json', 'r', encoding='utf-8') as file:
        json = task0.parse_json(file)


def check_1():
    json_file = 'schedule.json'
    yaml_file = 'example.yaml'
    task1.json_to_yaml(json_file, yaml_file)


def check_2():
    with open('schedule.json', 'r', encoding='utf-8') as file:
        json = task2.parse_json(file)


time0 = timeit.timeit(check_0, number=100)
time1 = timeit.timeit(check_0, number=100)
time2 = timeit.timeit(check_0, number=100)

print(time0, time1, time2, sep='\n')
