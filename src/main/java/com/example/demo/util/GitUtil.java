package com.example.demo.util;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.springframework.stereotype.Component;
@Component
public class GitUtil {
    //克隆仓库
    public String cloneRepository(String url, String localPath) {
        try {
            System.out.println("开始下载......");

            Git git = Git.cloneRepository()
                    .setURI(url)
                    .setDirectory(new File(localPath))
                    .setCloneAllBranches(true)
                    .call();

            System.out.println("下载完成......");

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
