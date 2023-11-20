## 사전 설치

* brew install prometheus
* brew install grafana
* brew services start prometheus grafana

prometheus 에서 default Port는 9090이다. 

prometheus.yml 에 `scrape_configs` 설정 
* ex ) 
```yaml
- job_name: "spring-actuator"
    metrics_path: 'actuator/prometheus'
    scarpe_interval: 1s
    static_configs:
        -targets: ['localhost:8080']
```
## 작동 확인
[prometheus](http://localhost:9090) 에 들어가서 Status Target 상태 확인 



