echo "Тест 2" '\n'
echo "Входные файлы:" '\n'
echo "in1.txt:" '\n'
cat in1.txt
echo '\n' '\n' "in2.txt:" '\n'
cat in2.txt
echo '\n'

echo "java -jar util-1.0-SNAPSHOT.jar -f -o some_dir -p sample- in1.txt in2.txt" '\n'

java -jar util-1.0-SNAPSHOT.jar -f -p sample- in1.txt in2.txt

echo "Выходные файлы:" '\n'

echo "some_dir/sample-integers.txt" '\n'
cat some_dir/sample-integers.txt
echo "some_dir/sample-floats.txt" '\n'
cat some_dir/sample-floats.txt
echo "some_dir/sample-strings.txt" '\n'
cat some_dir/sample-strings.txt