echo "Тест 1" '\n'
echo "Входные файлы:" '\n'
echo "in1.txt:" '\n'
cat in1.txt
echo '\n' '\n' "in2.txt:" '\n'
cat in2.txt
echo '\n'

echo "java -jar util-1.0-SNAPSHOT.jar -f -p sample- in1.txt in2.txt" '\n'

java -jar util-1.0-SNAPSHOT.jar -f -p sample- in1.txt in2.txt

echo "Выходные файлы:" '\n'

echo "sample-integers.txt" '\n'
cat sample-integers.txt
echo "sample-floats.txt" '\n'
cat sample-floats.txt
echo "sample-strings.txt" '\n'
cat sample-strings.txt
