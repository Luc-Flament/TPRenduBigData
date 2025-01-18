package org.epf.hadoop.colfil2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class UserRelationsMapper extends Mapper<LongWritable, Text, UserPair, IntWritable> {
    private static final IntWritable ONE = new IntWritable(1);
    private static final IntWritable ZERO = new IntWritable(0);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] parts = value.toString().split("\t");
        if (parts.length != 2) {
            return;
        }

        String user = parts[0];
        String[] relations = parts[1].split(",");
        for (int i = 0; i < relations.length; i++) {
            for (int j = i + 1; j < relations.length; j++) {
                UserPair pair = new UserPair(relations[i], relations[j]);
                context.write(pair, ONE);
            }
        }
        for (String relation : relations) {
            UserPair existingRelation = new UserPair(user, relation);
            context.write(existingRelation, ZERO);
        }
    }
}

