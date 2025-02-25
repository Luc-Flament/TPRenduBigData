package org.epf.hadoop.colfil1;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.HashSet;

public class RelationshipReducer extends Reducer<Text, Text, Text, Text> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        HashSet<String> uniqueRelations = new HashSet<>();
        for (Text value : values) {
            uniqueRelations.add(value.toString());
        }
        String joinedRelations = String.join(",", uniqueRelations);
        context.write(key, new Text(joinedRelations));
    }
}