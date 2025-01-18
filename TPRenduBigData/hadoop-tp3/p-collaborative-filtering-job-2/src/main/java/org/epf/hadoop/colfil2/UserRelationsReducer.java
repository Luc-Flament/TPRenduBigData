package org.epf.hadoop.colfil2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class UserRelationsReducer extends Reducer<UserPair, IntWritable, UserPair, IntWritable> {
    @Override
    protected void reduce(UserPair key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;
        boolean isExistingRelation = false;

        for (IntWritable value : values) {
            if (value.get() == 0) {
                isExistingRelation = true;
                break;
            }
            sum += value.get();
        }

        if (!isExistingRelation && sum > 0) {
            context.write(key, new IntWritable(sum));
        }
    }
}