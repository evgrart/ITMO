from re import fullmatch
from re import DOTALL
with open("schedule.json", 'r', encoding='utf-8') as file:
    def parse_json(json):
        json = json.read().strip()
        if json.startswith('{'):
            return parse_object(json)
        elif json.startswith('['):
            return parse_list(json)
        else:
            raise ValueError("JSON должен начинаться с '{' или '['.")


    def level(string, delimeter):
        result = []
        current = []
        depth = 0
        for char in string:
            if char in '{[':
                depth += 1
            elif char in '}]':
                depth -= 1
            elif char == delimeter and depth == 0:
                result.append(''.join(current).strip())
                current = []
                continue
            current.append(char)

        if current:
            result.append(''.join(current).strip())
        return result


    def parse_object(string):
        obj = {}
        string = string[1:-1]
        pairs = level(string, ',')
        for pair in pairs:
            key, value = pair.split(':', 1)
            key = parse_value(key.strip())
            value = parse_value(value.strip())
            obj[key] = value
        return obj


    def parse_list(string):
        string = string[1:-1]
        result = [parse_value(i) for i in level(string, ',')]
        return result


    def parse_value(value):
        if fullmatch(r'null', value):  # null
            return None
        elif fullmatch(r'true', value):  # true
            return True
        elif fullmatch(r'false', value):  # false
            return False
        elif fullmatch(r'\"[\w\s\S]*\"', value):  # Строка
            return value[1:-1]
        elif fullmatch(r'[-]?\d+', value):  # Целое число (+-)
            return int(value)
        elif fullmatch(r'[-]?\d+[.]\d+', value):  # Число с плавающей точкой
            return float(value)
        elif fullmatch(r'{.*}', value, DOTALL):  # Вложенный объект; DOTALL снимает ограничение с * на \n
            return parse_object(value)
        elif fullmatch(r'\[.*\]', value, DOTALL):  # Массив
            return parse_list(value)
        else:
            raise ValueError(f"Неизвестное значение: {value}")

    json = parse_json(file)
    print(json)

with open('schedule.yaml', 'w', encoding='utf-8') as yaml:
    def to_yaml(json, count=0):
        for i in json.keys():
            if isinstance(json[i], dict):
                yaml.write(f'{" " * count}{i}: \n')
                to_yaml(json[i], count + 2)
            elif isinstance(json[i], list):
                yaml.write(f'{" " * count}{i}: \n')
                for j in json[i]:
                    if isinstance(j, dict):
                        yaml.write(f'{" " * (count + 2)}- \n')
                        to_yaml(j, count + 4)
                    else:
                        yaml.write(f'{" " * (count + 2)}- {j} \n')
            else:
                yaml.write(f'{" " * count}{i}: {json[i]} \n')


    to_yaml(json)
