library(ggplot2)

data = read.table("http://chirayukong.github.io/infsci2725/resources/lecture4/Retention.txt", header = T)
summary(data)
ggplot(data , aes(x = apret)) + geom_histogram(binwidth=1) + theme_bw()
ggplot(data , aes(x = tstsc)) + geom_histogram(binwidth=1) + theme_bw()
ggplot(data , aes(x = salar)) + geom_histogram(binwidth=1) + theme_bw()
theme_set(theme_bw())
ggplot(data, aes(x = tstsc, y = apret)) + geom_point() + 
  geom_smooth(method=lm, 
              se=FALSE)
ggplot(data, aes(x = salar, y = apret)) + geom_point() + 
  geom_smooth(method=lm, 
              se=FALSE)
fit = lm(apret ~ tstsc+salar, data=data)
summary(fit)