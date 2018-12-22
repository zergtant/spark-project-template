#!/bin/bash
base_dir=$(cd `dirname ../../`; pwd)
echo '${base_dir}'
/bigdata/bin/spark-submit \
--class tant.spark.template.App \
${base_dir}/azkaban-project-1.0.180731.jar
