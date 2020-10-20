execute as @a[x=-270,y=201,z=-357,dx=6,dy=3,dz=1] at @s run playsound minecraft:task_completed master @s ~ ~ ~ 9999
tp @a[x=-270,y=201,z=-357,dx=6,dy=3,dz=1] @e[tag=navigation,tag=upload_data,limit=1]

execute as @e[tag=navigation,tag=upload_data,limit=1] run function scripts:decrement_task
function scripts:reset_tasks/navigation/upload_data

execute as @e[tag=task,tag=part2,tag=upload_data,limit=1,sort=random] run function scripts:increment_task