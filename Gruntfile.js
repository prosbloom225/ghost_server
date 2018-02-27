module.exports = function(grunt) {
    grunt.loadNpmTasks('grunt-shell');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.initConfig({
        shell: {
            greet: {
                command: function(greeting) {
                    return 'echo' + greeting;
                }
            },
            make: {
                command: 'mvn compile',
            },
            clean: {
                command: 'mvn clean',
            },
            execute: {
                command: 'java -jar ./target/ghost_server-1.0-SNAPSHOT-jar-with-dependencies.jar',
            },
            test: {
                command: "mvn test",
            }},
        watch: {
            java: {
                    files: ['**/*.java'],
                    tasks: ['test'],
                    options: {
                    forever: true,
                    spawn: false,
                     }
                },
             json: {
                    files: ['**/*.json'],
                    tasks: ['clean','test'],
                    options: {
                    forever: true,
                    spawn: false,
                    }
                }
        }
    });
    grunt.registerTask('default', ['watch']);
    grunt.registerTask('clean', ['shell:clean']);
    grunt.registerTask('build', ['shell:make']);
    grunt.registerTask('run', ['shell:clean', 'shell:make', 'shell:execute', 'shell:test']);
    grunt.registerTask('exec', ['shell:execute', 'shell:test']);
    grunt.registerTask('test', ['shell:test']);
};
