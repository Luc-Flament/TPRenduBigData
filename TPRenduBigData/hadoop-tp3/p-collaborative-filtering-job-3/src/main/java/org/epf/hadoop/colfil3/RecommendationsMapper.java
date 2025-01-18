package org.epf.hadoop.colfil3;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class RecommendationsMapper extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] parts = value.toString().split("\t");
        if (parts.length != 2) {
            return;
        }
        String[] users = parts[0].split(",");
        if (users.length != 2) {
            return;
        }
        String user1 = users[0];
        String user2 = users[1];
        String commonFriends = parts[1];
        context.write(new Text(user1), new Text(user2 + ":" + commonFriends));
        context.write(new Text(user2), new Text(user1 + ":" + commonFriends));
    }
}
