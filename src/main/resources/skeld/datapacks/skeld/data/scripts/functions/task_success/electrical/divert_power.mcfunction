execute as @a[x=-300,y=201,z=-335,dx=6,dy=3,dz=1] at @s run playsound minecraft:task_completed master @s ~ ~ ~ 9999
tp @a[x=-300,y=201,z=-335,dx=6,dy=3,dz=1] @e[tag=electrical,tag=divert_power,limit=1]

execute as @e[tag=electrical,tag=divert_power,limit=1] run function scripts:decrement_task
function scripts:reset_tasks/electrical/divert_power

execute as @e[tag=task,tag=part2,tag=!incomplete,tag=divert_power,limit=1,sort=random] run function scripts:increment_task