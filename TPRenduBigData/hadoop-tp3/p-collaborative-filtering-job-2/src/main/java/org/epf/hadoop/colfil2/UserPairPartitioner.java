package org.epf.hadoop.colfil2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class UserPairPartitioner extends Partitioner<UserPair, IntWritable> {

    @Override
    public int getPartition(UserPair key, IntWritable value, int numPartitions) {
        // Bon la c'est GPT qui m'a aidé à trouver cette fonction de partitionnement je l'avoue
        return Math.abs(key.getFirstUser().hashCode() % numPartitions);
    }
}
